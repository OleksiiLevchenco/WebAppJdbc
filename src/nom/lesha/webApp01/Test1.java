package nom.lesha.webApp01;

/**
 * @author Alexey Levchhenko
 */
public class Test1 {
    public static void main(String[] args){
        int r = 0;
        System.err.println("Print before TRY");
        try {
            System.err.println("Print in TRY before error");
            r=10/0;
            System.err.println("Print in TRY after error");
        } catch(Exception e) {
            System.err.println("Print from CATCH");
//            throw e;
        } finally {
            System.err.println("Print from Finally");
        }
        System.err.println("Print after Try - finally");

    }
}
