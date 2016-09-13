public class UnboundSortedArray {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };// 15 .16

		int target = 12;

		System.out.println(getIndex(nums, target));

	}

	public static int getIndex(int[] nums, int target) {

		// check array indexes 0, 2^0, 2^1, 2^2....

		int index = 0, exp = 0;

		while (true) {

			try {

				if (nums[index] == target) {

					return index;

				} else if (nums[index] < target) {

					index = (int) Math.pow(2, exp++);

				} else {

					break;

				}

			} catch (IndexOutOfBoundsException e) {

				break;

			}

		}

		// Binary Search

		int left = index / 2 + 1;

		int right = index - 1;

		int mid = 0;

		while (left <= right) {

			try {

				mid = left + (right - left) / 2;

				if (nums[mid] == target) {

					return mid;

				} else if (nums[mid] < target) {

					left = mid + 1;

				} else {

					right = mid - 1;

				}

			} catch (IndexOutOfBoundsException e) {

				right = mid - 1;

			}

		}

		return -1;

	}

}
