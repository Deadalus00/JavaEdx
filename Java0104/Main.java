public class Main {
    public static void main(String[] args) {
        String[] concepts = {"abstraction", "polymorphism", "inheritance", "encapsulation"};

        String result = new Object() {
            String searchStringArray(String target, String[] array) {
                String result = "not found";
                for (String element : array) {
                    if (element.equals(target)) {
                        result = "Found";
                        break;
                    }
                }
                return result;
            }
        }.searchStringArray("abstraction", concepts);
        System.out.println(result);

        result = searchStringArray("Being Cool", concepts);
        System.out.println(result);
    }
}
