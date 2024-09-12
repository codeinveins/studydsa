package com.mixer;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class BuildArrayFromPermutation {
    public static int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public static int[] buildArrayBigO1(int[] nums) {
        //{0,2,1,5,3,4}
        //nums[0] = nums[0] + (nums[nums[0]] % 6) * 6 => nums[0] = 0+(0%6)*6 = 0+0*6 = 0+0 = 0
        //nums[1] = nums[1] + (nums[nums[1]] % 6) * 6 => nums[1] = 2+(1%6)*6 = 2+1*6 = 2+6 = 8
        //nums[2] = nums[2] + (nums[nums[2]] % 6) * 6 => nums[2] = 1+(8%6)*6 = 1+2*6 = 2+12= 14
        //nums[3] = nums[3] + (nums[nums[3]] % 6) * 6 => nums[3] = 5+(4%6)*6 = 5+4*6 = 5+24= 29
        //nums[4] = nums[4] + (nums[nums[4]] % 6) * 6 => nums[4] = 3+(29%6)*6= 3+5*6 = 3+30= 33
        //nums[5] = nums[5] + (nums[nums[5]] % 6) * 6 => nums[5] = 4+(33%6)*6= 4+3*6 = 4+18= 22
        //{0,8,14,29,33,22}
        for(int i=0; i< nums.length; i++) {
            nums[i] += (nums[nums[i]] % nums.length) * nums.length;
        }

        //nums[0] = nums[0]/6 = 0/6 = 0
        //nums[1] = nums[1]/6 = 8/6 = 1
        //nums[2] = nums[2]/6 = 14/6= 2
        //nums[3] = nums[3]/6 = 29/6= 4
        //nums[4] = nums[4]/6 = 33/6= 5
        //nums[5] = nums[5]/6 = 22/6= 3
        //{0,1,2,4,5,3}

        for(int i=0; i<nums.length; i++) {
            nums[i] /= nums.length;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildArray(new int[]{0,2,1,5,3,4})));
        System.out.println(Arrays.toString(buildArrayBigO1(new int[]{0,2,1,5,3,4})));
    }
}


class ConcatArrayTwice {
    public static int[] getConcatenationUsingStream(int[] nums) {
        return IntStream.concat(Arrays.stream(nums), Arrays.stream(nums)).toArray();
    }

    public static int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];
        for(int i=0; i<nums.length*2; i++) {
            //3 = 0
            //4 = 1
            //5 = 2
            res[i] = nums[i%nums.length];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{0,2,1})));
    }
}

class ShuffleArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        //0,1,2,3,4,5, n=3

        //0,3,1,4,2,5
        for(int i=0,j=1,idx=0; i<res.length; i+=2,j+=2,idx++,n++) {
            res[i] = nums[idx];
            res[j] = nums[n];
            //i=0, j=1, idx=0, n=3   res[0] = nums[0] && res[1] = nums[3]
            //i=2, j=3, idx=1, n=4   res[2] = nums[1] && res[3] = nums[4]
            //i=4, j=5, idx=2, n=5   res[4] = nums[2] && res[5] = nums[5]

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{0,1,2,3,4,5}, 3)));
    }
}

class KidWithGreatestCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for(int i=1; i<candies.length; i++) {
            if(candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<candies.length; i++) {
            if(candies[i]+extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }
}

class DecodeXORedArray {
    public static int[] decode(int[] encoded, int first) {
        int[] org = new int[encoded.length+1];
        org[0] = first;
        for(int i=0; i<encoded.length; i++) {
            org[i+1] = encoded[i]^org[i];
        }
        return org;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{1,2,3}, 1)));
    }
}

class RunningSumOf1dArray {
    public static int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            output[i] = output[i-1]+nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1,1,1,1,1})));
    }
}

class FindHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int high=0;
        int curr=0;
        for(int i=0; i<gain.length; i++) {
            curr += gain[i];
            if(high < curr) {
                high = curr;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
    }
}


//A pair (i, j) is called good if nums[i] == nums[j] and i < j.
class GoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> countNumMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(countNumMap.containsKey(nums[i])) {
                int currValue = countNumMap.get(nums[i]);
                countNumMap.put(nums[i], currValue+1);
            } else {
                countNumMap.put(nums[i], 1);
            }
        }

        int count = 0;
        for(int key : countNumMap.keySet()) {
            if(countNumMap.get(key) > 1) {
                int countOfNum = countNumMap.get(key);
                count += (countOfNum*(countOfNum-1))/2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }
}

class RingsAndRods {
    public static int countPoints(String rings) {
        List<Boolean[]> output = new ArrayList<>();
        for(int i=0; i<9; i++) {
            output.add(new Boolean[]{false,false,false});
        }
        for(int i=1; i<rings.length(); i+=2) {
            int currRodNum = Integer.parseInt(rings.charAt(i)+"");
            String currColor = rings.charAt(i-1)+"";
            System.out.println("*"+currRodNum + " -- " + currColor);

            Boolean[] currVal = output.get(currRodNum);
            System.out.println("**"+Arrays.toString(currVal));

            if(currColor.equals("R")) {
                currVal[0] = true;
            } else if(currColor.equals("G")) {
                currVal[1] = true;
            } else {
                currVal[2] = true;
            }
            System.out.println("**"+Arrays.toString(currVal));
            output.set(currRodNum, currVal);


            /*
            String currRod = output.get(Integer.parseInt(rings.charAt(i)+""));

            if(null == curr || "".equals(curr))
                output.put(Integer.parseInt(rings.charAt(i)+""), rings.charAt(i-1)+"");
            else {
                output.put(Integer.parseInt(rings.charAt(i)+""), curr+rings.charAt(i-1));
            }*/
        }

        //System.out.println(Arrays.toString(output));
        int count = 0;
        for(Boolean[] valArray : output) {
            if(!Arrays.asList(valArray).contains(false)) {
                count++;
            }
        }



        /*
        for(Integer key : output.keySet()) {
            String colors = output.get(key);
            if(colors.contains("R") && colors.contains("G") && colors.contains("B")) {
                count++;
            }
        }*/

        return count;
    }

    public static void main(String[] args) {
        //System.out.println(countPoints("B0B6G0R6R0R6G9"));
        String s = "abcdefg";
        char[] c = new char[]{'s','d','f','g'};
        String w = String.valueOf(c);
        System.out.println(w);

    }
}
class AddDigits {


    static int sum = 0;
    public static int addDigits(int num) {
        if(!isSingleDigit(num)) {
            sum = sum+num%10;
            num = num/10;
            addDigits(num);
        }
        int finalSum = sum+num;
        if(!isSingleDigit(finalSum)) {
            sum=0;
            addDigits(finalSum);
        }
        return finalSum;

        /*
        do {
            sum += num%10;
            num = num/10;
        }while(!isSingleDigit(num));
        sum+=num;

        if(!isSingleDigit(sum)) {
            addDigits(sum);
        }
        return sum;*/
    }

    private static boolean isSingleDigit(int num) {
        if(num/10 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(addDigits(38));
        parseTimeStamps("1723596180");
    }

    private String parseTimeStampsUTC(String token) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(token);

        while (m.find()) {
            String time = m.group();
            // The input value is in seconds, convert it to milliseconds
            long milliseconds = Long.parseLong(time) * 1000L;

            // Create a Date object from the milliseconds
            Date sqlDate = new Date(milliseconds);

            // Format the date in the desired pattern
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss a");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

            String timestamp = formatter.format(sqlDate);

            // Replace the original time value in the token with the formatted timestamp
            token = token.replace(time, timestamp);
        }

        System.out.println("parsed timestamp = " + token);
        return token;
    }
}