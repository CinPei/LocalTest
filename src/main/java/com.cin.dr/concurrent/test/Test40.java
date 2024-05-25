package com.cin.dr.concurrent.test;

import java.util.Map;

public class Test40 {
    public static void main(String[] args) {
        String a = "78";
        String b = "89";
        int result = test(a,b);
        System.out.println(result);
    }
    private static int test(String a, String b){
        int result = 0;

        byte[] as = a.getBytes();
        byte[] bs = b.getBytes();
        int alen = as.length;
        int bLen = bs.length;
        int min = Math.min(alen, bLen);
        int jin = 0;
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < min; j++) {
                int temp1 = as[i];
                int temp2 = bs[j];
                int temp = temp1 + temp2 + jin;
                int tempY = temp % 10;
                System.out.println(temp1 +"_"+ temp2 +"_"+ temp +"_"+ tempY);
                if(tempY > 0){
                    result++;
                }
                jin = tempY;
            }
        }
        return result;
    }

    public int myAtoi(String s) {
        s = s.trim();
        boolean flag = true;
        if(s.startsWith("-")){
            flag = false;
            s=s.substring(1);
        } else if(s.startsWith("+")){
            flag = true;
            s=s.substring(1);
        }
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(48<=s.charAt(i) && s.charAt(i)<=57){
            sb.append(s.charAt(i));
            if(i>s.length()-1){
                break;
            }

            i++;
        }
        for(int j=0;i<sb.length();){
            if(sb.charAt(j)== '0')
            {
                sb.delete(0,1);

            }
            else
                break;
        }
        int[] nums = new int[s.length()];
        int num = 0;
        for(int k=0;k<s.length();k++){
            nums[k] = s.charAt(k) - '0';
            num += nums[k]*10 + nums[k];
            if(flag && k+1<s.length() && s.charAt(k+1)>='0' && s.charAt(k+1)<='9' && num > Integer.MAX_VALUE/10)
                return Integer.MAX_VALUE;
            if(flag && k+1<s.length() && s.charAt(k+1)>='0' && s.charAt(k+1)<='9' && num == Integer.MAX_VALUE/10 && s.charAt(k+1)-'0' > Integer.MAX_VALUE%10)
                return Integer.MAX_VALUE;
            if(flag && k+1<s.length() && s.charAt(k+1)>='0' && s.charAt(k+1)<='9' && -num < Integer.MIN_VALUE/10)
                return Integer.MIN_VALUE;
            if(flag && k+1<s.length() && s.charAt(k+1)>='0' && s.charAt(k+1)<='9' && -num == Integer.MIN_VALUE/10 && -(s.charAt(k+1)-'0') < Integer.MIN_VALUE%10)
                return Integer.MIN_VALUE;
        }
        return (flag?1:-1)*num;
    }
}
