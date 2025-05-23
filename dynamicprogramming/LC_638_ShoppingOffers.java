package dynamicprogramming;

import java.util.*;

public class LC_638_ShoppingOffers {

    /* 
    TC: O(k^n * m)
    SC: O(k^n)
    where:
      n = number of items,
      m = number of special offers,
      k = average max quantity per item in needs.

    For each unique combination of item needs (max k^n combinations),
    we try up to m special offers. We memoize each state to avoid recomputation.
     */

    static class ShoppingOffersSolver {
        Map<List<Integer>, Integer> memo;

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            // Use a more reliable memoization approach with custom key class
            memo = new HashMap<>();
            return dfs(price, special, needs);
        }

        private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            // Create a copy of needs to use as key for memoization
            List<Integer> key = new ArrayList<>(needs);
            
            // Check if we've already computed this state
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            
            // Calculate cost without any special offers
            int minCost = directPurchaseCost(price, needs);
            
            // Try applying each special offer
            for (List<Integer> offer : special) {
                boolean canUseOffer = true;
                List<Integer> remainingNeeds = new ArrayList<>(needs.size());
                
                // Check if we can apply this offer
                for (int i = 0; i < needs.size(); i++) {
                    if (needs.get(i) < offer.get(i)) {
                        canUseOffer = false;
                        break;
                    }
                    remainingNeeds.add(needs.get(i) - offer.get(i));
                }
                
                if (canUseOffer) {
                    int offerPrice = offer.get(offer.size() - 1);
                    int remainingCost = dfs(price, special, remainingNeeds);
                    minCost = Math.min(minCost, offerPrice + remainingCost);
                }
            }
            
            // Memoize and return
            memo.put(key, minCost);
            return minCost;
        }
        
        private int directPurchaseCost(List<Integer> price, List<Integer> needs) {
            int cost = 0;
            for (int i = 0; i < needs.size(); i++) {
                cost += needs.get(i) * price.get(i);
            }
            return cost;
        }
    }

    public static void main(String[] args) {
        ShoppingOffersSolver solver = new ShoppingOffersSolver();

        // Test Case 1
        List<Integer> price1 = Arrays.asList(2, 5);
        List<List<Integer>> special1 = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        List<Integer> needs1 = Arrays.asList(3, 2);
        System.out.println(solver.shoppingOffers(price1, special1, needs1)); // Expected: 14

        // Test Case 2: No special offers applicable
        List<Integer> price2 = Arrays.asList(2, 3, 4);
        List<List<Integer>> special2 = Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9));
        List<Integer> needs2 = Arrays.asList(1, 1, 1);
        System.out.println(solver.shoppingOffers(price2, special2, needs2)); // Expected: 11

        // Test Case 3: Edge case - zero needs
        List<Integer> price3 = Arrays.asList(2, 3);
        List<List<Integer>> special3 = Arrays.asList(Arrays.asList(1, 1, 4));
        List<Integer> needs3 = Arrays.asList(0, 0);
        System.out.println(solver.shoppingOffers(price3, special3, needs3)); // Expected: 0

        // Test Case 4: Edge case - large needs but no special offer helps
        List<Integer> price4 = Arrays.asList(1, 1, 1);
        List<List<Integer>> special4 = Arrays.asList(Arrays.asList(0, 0, 0, 999));
        List<Integer> needs4 = Arrays.asList(99, 99, 99);
        System.out.println(solver.shoppingOffers(price4, special4, needs4)); // Expected: 297
    }
}