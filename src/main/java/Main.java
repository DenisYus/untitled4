import java.net.URI;

public class Main {
    public static void main(String[] args) {
    QueueStorage queueStorage = new QueueStorage();
    queueStorage.add("s", URI.create("http://198.17.25.03"));
        System.out.println(queueStorage.storage);
        queueStorage.add("s", URI.create("http://198.17.25.04"));
        System.out.println(queueStorage.storage);
        queueStorage.add("ad", URI.create("http://198.17.25.03"));
        queueStorage.add("a", URI.create("http://198.17.25.03"));
        queueStorage.add("ab", URI.create("http://198.17.25.03"));
        queueStorage.add("c", URI.create("http://198.17.25.03"));
        queueStorage.add("d", URI.create("http://198.17.25.03"));
        queueStorage.add("e", URI.create("http://198.17.25.03"));
        queueStorage.add("ae", URI.create("http://198.17.25.03"));
        queueStorage.add("as", URI.create("http://198.17.25.03"));
        queueStorage.add("af", URI.create("http://198.17.25.03"));
        System.out.println(queueStorage.storage);
        System.out.println(queueStorage.storage.size());
        queueStorage.add("na", URI.create("http://198.17.25.03"));
        System.out.println(queueStorage.storage);
        System.out.println(queueStorage.storage.size());


    }
}
