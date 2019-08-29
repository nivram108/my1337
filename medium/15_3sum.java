
class Solution {
    HashMap<String, Boolean> uniqAnswer;
    List<List<Integer>> solution;
    public List<List<Integer>> threeSum(int[] nums) {

        solution = new ArrayList<>();
        uniqAnswer = new HashMap<>();
        if(nums.length < 3) return solution;
        sortDescend(nums);
        int minElement = nums[nums.length - 1];
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] < 0) break;
            for(int j = i + 1; j < nums.length - 1; j ++) {
                int[] triplet = new int[3];
                triplet[0] = nums[i];
                triplet[1] = nums[j];
                triplet[2] = 0;
                printTriplet(triplet);
                triplet[2] = getThirdElement(nums, triplet, j + 1, nums.length - 1);
                toUniqueTriplet(triplet);
            }
        }
        return solution;
    }
    int getThirdElement(int[] nums, int[] triplet, int l, int r) {
        int mid = (l + r) / 2;
        // System.out.println(mid);
        int sum = triplet[0] + triplet[1];
        if(nums[mid] + sum == 0) return nums[mid];
        if(mid == r || mid == l) {
            triplet[0] = -1;
            return - 1;
        }

        if(nums[mid] + sum > 0) return getThirdElement(nums, triplet, l, mid);
        else return getThirdElement(nums, triplet, mid, r);
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
