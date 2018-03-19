package com.wdq.test;

import com.wdq.encrypt.Encrypt;

/**
 * pow 简易证明实现
 */
public class TestProof {

    /**
     * 简单的工作量证明:
     * - 查找一个 p' 使得 hash(pp') 以4个0开头
     * - p 是上一个块的证明, p' 是当前的证明
     * @param last_proof
     * 上一个块的证明
     * @return
     */
    public long proofOfWork(long last_proof) {
        long proof = 0;
        while (!validProof(last_proof, proof)) {
            proof += 1;
        }
        return proof;
    }

    /**
     * 验证证明: 是否hash(last_proof, proof)以4个0开头?
     * @param last_proof
     * 上一个块的证明
     * @param proof
     * 当前的证明
     * @return 以4个0开头返回true，否则返回false
     */
    public boolean validProof(long last_proof, long proof) {
        String guess = last_proof + "" + proof;
        String guess_hash = new Encrypt().getSHA256(guess);
        return guess_hash.startsWith("0000");
    }



    public static void main(String[] args) {
        System.out.println(new TestProof().proofOfWork(11l));
    }

}
