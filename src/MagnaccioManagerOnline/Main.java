package MagnaccioManagerOnline;
/**
 * @author HarlockOfficial
 */
public class Main {
	public static void main(String[] args) {
        Network n=new Network();
        n.go();
        new Map(n);
    }
}
