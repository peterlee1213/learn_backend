public class TestClass {

}

/**
 * ChildInterface
 */
public interface ChildInterface extends ParentInterface {
    List<String> select();
}

/**
 * ParentInterface
 */
public interface ParentInterface {
    Iterable<String> select();
}
