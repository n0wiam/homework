package org.nowiam.util;

public class HammingUtil {
    public static int getHammingDistance(String simHash1, String simHash2) {
        int hammingDistance = 0;
        if (simHash1.length() != simHash2.length()) {
            // 出错，返回-1
            hammingDistance = -1;
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                // 每一位进行比较
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    hammingDistance++;
                }
            }
        }
        return hammingDistance;
    }

    public static double getResult(String simHash1, String simHash2) {
        // 通过 simHash1 和 simHash2 获得它们的海明距离
        int distance = getHammingDistance(simHash1, simHash2);
        // 通过海明距离计算出相似度，并返回
        double result=0.01 * (100 - distance * 100 / 128);
        return result;
    }
}
