package Directory;

public class test {
    public static void main(String[] args) {
        String s = "/te/st";

        String[] arr = s.split("/");
        for(String a : arr)
        System.out.println("->"+a);
    }
}
