package Backjoon_OJ.Bronze1;

import java.io.*;

public class No1157_byte {
    
    static final byte A64 = (byte)64;
    
    public static void main(String[] args) throws IOException{
        InputStream is = System.in;
        byte[] buf = new byte[1000003];
        is.read(buf);
        
        int[] cnt = new int[27];
        
        for(int i = 0; buf[i] > A64; i++) {
        	cnt[buf[i] & 31]++;
        }
        
        int max_idx = 0;
        int max_val = 0; 
        int same_val = 0;
        
        for(int i = 1; i < 27; i++){
            if(max_val<cnt[i]) {
            	max_idx = i; 
            	max_val = cnt[i];
            } else if(max_val == cnt[i]) {
            	same_val = max_val;
            }
        }
        
        if(max_val == same_val) {
        	System.out.print('?');
        } else {
        	System.out.print((char)(max_idx + 64));
        }
    }
}