/**
 * @author tree
 * @date 2022/2/20 22:31
 * 717. 1-bit and 2-bit Characters
 * 717. 1比特与2比特字符
 */
public class O717 {


    public boolean isOneBitCharacter(int[] bits) {

        return subIsOneBitCharacter(bits, 0);
    }

    private boolean subIsOneBitCharacter(int[] bits, int index) {
        if (index == bits.length) {
            return false;
        }

        if (index == bits.length - 1) {
            return bits[index] == 0;
        }
        boolean res = false;
        if (bits[index] == 0) {
            res = res | subIsOneBitCharacter(bits, index + 1);
        } else {
            res = res | subIsOneBitCharacter(bits, index + 2);
        }
        return res;
    }
}
