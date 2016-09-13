package array2;

public class CreatMaxNumber {

//	 public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//	        // Write your code here
//	        if (k == 0)
//	            return new int[0];
//
//	        int m = nums1.length, n = nums2.length;
//	        if (m + n < k) return null;
//	        if (m + n == k) {
//	            int[] results = merge(nums1, nums2, k);
//	            return results;
//	        } else {
//	            int max = m >= k ? k : m;
//	            int min = n >= k ? 0 : k - n;
//
//	            int[] results = new int[k];
//	            for(int i=0; i < k; ++i)
//	                results[i] = -0x7ffffff;
//	            for(int i = min; i <= max; ++i) {
//	                int[] temp = merge(getMax(nums1, i), getMax(nums2, k - i), k);
//	                results = isGreater(results, 0, temp, 0) ? results : temp;
//	            }
//	            return results;
//	        }
//	    }
//
//	    private int[] merge(int[] nums1, int[] nums2, int k) {
//	        int[] results = new int[k];
//	        if (k == 0) return results;
//	        int i = 0, j = 0;
//	        for(int l = 0; l < k; ++l) {
//	            results[l] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
//	        }
//	        return results;
//	    }
//
//	    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
//	        for(; i < nums1.length && j < nums2.length; ++i, ++j) {
//	            if (nums1[i] > nums2[j])
//	                return true;
//	            if (nums1[i] < nums2[j])
//	                return false;
//	        }
//	        return i != nums1.length;
//	    }
//
//	    private int[] getMax(int[] nums, int k) {
//	        if (k == 0)
//	            return new int[0];
//	        int[] results = new int[k];
//	        int i = 0;
//	        for(int j = 0; j < nums.length; ++j) {
//	            while(nums.length - j + i > k && i > 0 && results[i-1] < nums[j])
//	                i--;
//	            if (i < k)
//	                results[i++] = nums[j];
//	        }
//	        return results;
//	    }
	    
	/**
	 * Created by hrwhisper on 2015/11/23.
	 * https://www.hrwhisper.me/leetcode-create-maximum-number/
	 */

	    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
	        int[] ans = new int[k];
	        for (int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
	            int[] res1 = get_max_sub_array(nums1, i);
	            int[] res2 = get_max_sub_array(nums2, k - i);
	            int[] res = new int[k];
	            int pos1 = 0, pos2 = 0, tpos = 0;

	            while (pos1 < res1.length || pos2 < res2.length) {
	                res[tpos++] = greater(res1, pos1, res2, pos2) ? res1[pos1++] : res2[pos2++];
	            }

	            if (!greater(ans, 0, res, 0))
	                ans = res;
	        }

	        return ans;
	    }

	    public boolean greater(int[] nums1, int start1, int[] nums2, int start2) {
	        for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
	            if (nums1[start1] > nums2[start2]) return true;
	            if (nums1[start1] < nums2[start2]) return false;
	        }
	        return start1 != nums1.length;
	    }

	    public int[] get_max_sub_array(int[] nums, int k) {
	        int[] res = new int[k];
	        int len = 0;
	        for (int i = 0; i < nums.length; i++) {
	            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {//??
	                len--;
	            }
	            if (len < k)
	                res[len++] = nums[i];
	        }
	        return res;
	    }
	    
}
