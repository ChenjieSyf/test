package TiJavaTest;

/**
 * Created by chenjie on 16/10/31.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] aa = {1, 2};
        for (int i = 0; i < (nums.length / 2) + 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode r = new ListNode(0);

        int i1 = (l1.val + l2.val) % 10;
        int carry1 = (l1.val + l2.val) / 10;
        r.val = r.val + i1;
        r.next = new ListNode(carry1);
        ListNode r1 = r;

        while ((l1.next != null || l2.next != null) && (r1.next != null)) {
            if (l1.next == null) {
                l1 = new ListNode(0);
            } else {
                l1 = l1.next;
            }
            if (l2.next == null) {
                l2 = new ListNode(0);
            } else {
                l2 = l2.next;
            }


            r1 = r1.next;
            int i = (l1.val + l2.val) % 10;
            int carry = (l1.val + l2.val) / 10;
            r1.val = r1.val + i;
            if (r1.val > 9) {
                r1.next = new ListNode(r1.val / 10);
                r1.val = r1.val % 10;
            } else {
                r1.next = new ListNode(carry);
            }

        }
        if (r1.val > 9) {
            r1.next = new ListNode(r1.val / 10);
            r1.val = r1.val % 10;

        }

        if (r1.next.val == 0)
            r1.next = null;

        return r;

    }


   /* Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
/*
        for (int i = 0; i < s.length(); i++) {

            if (isRepeat(s, String.valueOf(s.charAt(i)))) {
                if(maxLength==0) maxLength=1;
                continue;
            }
            int index = 1;
            while ( (index < s.length() - i-index)&&  !isRepeat(s, s.substring(i, index))) {

                index++;
                if (index > maxLength) maxLength = index;
            }


        }*/

        for (int i = 0; i < s.length(); i++) {
            if (maxLength > (s.length() - i)) return maxLength;
            for (int j = i; j <= s.length(); j++) {
                if (!isRepeat(s.substring(i, j))) {
                    int length = j - i;
                    if (length > maxLength) {

                        maxLength = length;
                    }
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }

    public static boolean isRepeat(String sub) {

        boolean flag = false;
        // System.out.println(sub );
        for (int i = 0; i < sub.length(); i++) {
            int count = 0;
            char c = sub.charAt(i);
            int index = 0;
            while (index < sub.length()) {
                if (c == sub.charAt(index)) count++;

                if (count > 1) {
                    flag = true;
                    return flag;
                }
                index++;

            }


        }


        return flag;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combinNums = new int[nums1.length + nums2.length];
        double miden = 0;
        int i = 0, j = 0, k = 0;
        boolean flagI = true;
        boolean flagJ = true;
        while (i < nums1.length || j < nums2.length) {


            if (flagJ && nums1[i] >= nums2[j]) {
                combinNums[k] = nums2[j];
                k++;
                j++;
                if (j == nums2.length) flagJ = false;
            } else if (flagI && nums1[i] < nums2[j]) {
                combinNums[k] = nums1[i];
                i++;
                k++;
                if (i == nums1.length) flagI = false;
            } else if (!flagI) {


                combinNums[k] = nums2[j];
                k++;
                j++;


            } else {

                combinNums[k] = nums1[i];
                i++;
                k++;


            }
        }

        int index = combinNums.length / 2;
        if (combinNums.length % 2 == 0) {

            miden = ((double) combinNums[index] + (double) combinNums[index - 1]) / (2.0);

        } else {
            miden = (double) combinNums[index];
        }

        return miden;

    }

    public static void main(String[] args) {
       /*int [] a={3,2,4};
        int [] res = new Solution().twoSum(a, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }*/


        /*ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(8);
        ListNode l111 = new ListNode(9);
        ListNode l1111 = new ListNode(9);
        l1.next = l11;
        l11.next = l111;
        l111.next = l1111;


        ListNode l2 = new ListNode(2);
        ListNode l21 = new ListNode(4);
        ListNode l211 = new ListNode(3);
        ListNode l2111 = new ListNode(2);
        l2.next = l21;
        l21.next = l211;
        l211.next = l2111;

        ListNode r = new Solution().addTwoNumbers(l11, l2111);

        System.out.println(r.val);
        while (r.next != null) {
            r = r.next;
            System.out.println(r.val);
        }
*/

        // System.out.println("stringtri".replaceFirst("ri",""));
        // System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));

        // System.out.println(s);
        // System.out.println("aab".substring(0,3));

        //   String s1="DEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABC";
        // System.out.println(isRepeat(s1));

        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 4, 7}, new int[]{5, 17, 19}));
        ;
    }
}
