
class Solution {
    HashMap<String, Boolean> uniqAnswer;
    HashMap<Integer, Boolean> uniqHead;
    List<List<Integer>> solution;
    public List<List<Integer>> threeSum(int[] nums) {

        uniqHead = new HashMap<>();
        solution = new ArrayList<>();
        uniqAnswer = new HashMap<>();
        if(nums.length < 3) return solution;
        sortDescend(nums);
        int minElement = nums[nums.length - 1];
        int k = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] < 0 ) break; // the greatest element < 0
            else if (uniqHead.containsKey(nums[i])) continue; // all solutions which greatest element are nums[i] are included
            for(int j = i + 1; j < nums.length - 1; j ++) {
                int[] triplet = new int[3];
                triplet[0] = nums[i];
                triplet[1] = nums[j];
                triplet[2] = 0;
                // printTriplet(triplet);
                triplet[2] = getThirdElement(nums, triplet, j + 1, nums.length - 1); // binary search for matched third element
                toUniqueTriplet(triplet); // add to list if the solution is new
            }
        }
        return solution;
    }
    int getThirdElement(int[] nums, int[] triplet, int l, int r) {
        int mid = (l + r) / 2;
        // System.out.print(l);
        // System.out.print(",");
        // System.out.print(r);
        // System.out.print(":");
        // System.out.println(nums[mid]);
        int sum = triplet[0] + triplet[1];
        if(l > r) {
            triplet[0] = -1;
            return - 1;
        }
        if(nums[mid] + sum == 0) return nums[mid];

        if(nums[mid] + sum < 0) return getThirdElement(nums, triplet, l, mid - 1);
        else return getThirdElement(nums, triplet, mid + 1, r);
    }
    void toUniqueTriplet(int[] triplet) {
        if(triplet[0] < 0) return;
        String key = tripletToKey(triplet);
        if(uniqAnswer.containsKey(key) || sum(triplet) != 0) {
            return;
        } else {
            List<Integer> l = new ArrayList<>();
            for(int e : triplet) {
                l.add(e);
            }
            solution.add(l);
            uniqAnswer.put(key, true);
            uniqHead.put(triplet[0], true);
        }
    }

    String tripletToKey(int[] triplet) {
        String key = "";
        key += Integer.toString(triplet[0]) + ",";
        key += Integer.toString(triplet[1]) + ",";
        key += Integer.toString(triplet[2]);
        return key;
    }

    void sortDescend(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] < array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    int sum(int[] array) {
        int s = 0;
        for(int e : array) s += e;
        return s;
    }

    void printTriplet(int[] triplet) {
        System.out.print(triplet[0]);
        System.out.print(",");
        System.out.print(triplet[1]);
        System.out.print(",");
        System.out.println(triplet[2]);
    }
}
