package test.java.com.neet;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.neet.Solution;
public class SolutionTest {
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Solution s = new Solution();
        int[] stones = {2,3,6,2,4};
        int r = s.lastStoneWeight(stones);
        assertEquals(r, 1);
    }
}
