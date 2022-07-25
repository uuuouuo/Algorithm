class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class 더블연결리스트 {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = null;
    }

    public void addNode2Head(int data) {
        if (head == null) {
            head = getNode(data);
            return;
        }

        Node nNode = getNode(data);
        nNode.next = head;
        head.prev = nNode;
        head = nNode;
    }

    public void addNode2Tail(int data) {
        if (head == null) {
            head = getNode(data);
            return;
        }

        Node curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        Node nNode = getNode(data);
        nNode.prev = curNode;
        curNode.next = nNode;
    }

    public void addNode2Num(int data, int num) {
        if (head == null) {
            head = getNode(data);
            return;
        }
        if (num == 1) {
            addNode2Head(data);
            return;
        }
        if (nodeCnt < num) {
            addNode2Tail(data);
            return;
        }

        int cnt = 1;
        Node curNode = head;
        Node preNode = null;
        while (true) {
            if (num == cnt) {
                if (curNode == null) {
                    addNode2Tail(data);
                    return;
                }
                preNode = curNode.prev;
                break;
            }
            curNode = curNode.next;
            cnt++;
        }

        Node nNode = getNode(data);
        preNode.next = nNode;
        nNode.prev = preNode;
        nNode.next = curNode;
        curNode.prev = nNode;
    }

    public int findNode(int data) {
        int cnt = 1;
        Node curNode = head;
        while (true) {
            if (curNode == null)
                return -1;
            if (curNode.data == data)
                return cnt;

            curNode = curNode.next;
            cnt++;
        }
    }

    public void removeNode(int data) {
        Node curNode = head;
        Node preNode = null;
        Node nextNode = null;

        if (head.data == data) {
            head = head.next;
            return;
        }

        while (true) {
            if (curNode == null)
                return;
            if (curNode.data == data) {
                preNode = curNode.prev;
                nextNode = curNode.next;
                break;
            }
            curNode = curNode.next;
        }

        if (nextNode == null) {
            preNode.next = null;
            return;
        }
        preNode.next = nextNode;
        nextNode.prev = preNode;
    }

    public int getList(int[] output) {
        Node curNode = head;
        output[0] = curNode.data;
        int idx = 1;
        while (curNode.next != null) {
            curNode = curNode.next;
            output[idx] = curNode.data;
            idx++;
        }
        return idx;
    }

    public int getReversedList(int[] output) {
        Node tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }

        int idx = 1;
        output[0] = tailNode.data;
        while (tailNode.prev != null) {
            tailNode = tailNode.prev;
            output[idx] = tailNode.data;
            idx++;
        }
        return idx;
    }
}