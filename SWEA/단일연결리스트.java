class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null; // 다음 노드 data 저장
    }
}

public class 단일연결리스트 {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) { // 새로운 node 할당
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = null;
    }

    // 새로운 node 생성 후 이 노드의 next가 head 가리키기
    public void addNode2Head(int data) {
        if (head == null) {
            head = getNode(data);
            return;
        }

        Node nHead = getNode(data);
        nHead.next = head;
        head = nHead;
    }

    // 마지막 node 찾은 후 이 node가 새로 생성한 node 가리키기
    public void addNode2Tail(int data) {
        if (head == null) {
            head = getNode(data);
            return;
        }

        Node curNode = head; // head 찾아서 tail 찾아야함
        while (curNode.next != null) { // 현재 node next가 null인 지점 찾기
            curNode = curNode.next; // null이 아니라면 다음 next node가 cur
        }

        Node nTail = getNode(data); // 새로운 tail 생성
        curNode.next = nTail;

    }

    // 해당 순서 앞node는 새로운node 가리키고 새로운node는 해당 순서였던 node 가리키고
    public void addNode2Num(int data, int num) {
        if (head == null) {
            head = getNode(data);
            return;
        }
        if (num == 1) { // 맨앞에 넣을 경우
            addNode2Head(data);
            return;
        }
        if (nodeCnt < num) { // 맨뒤에 넣을 경우
            addNode2Tail(data);
            return;
        }

        Node curNode = head;
        Node preNode = null;
        int cnt = 1;
        while (true) {
            if (cnt == num - 1) {
                preNode = curNode;
                curNode = curNode.next;
                break;
            }
            curNode = curNode.next;
            cnt++;
        }

        Node nNode = getNode(data);
        preNode.next = nNode;
        nNode.next = curNode;

    }

    // 해당 data의 node 찾아서 해당 node의 앞node & 다음node 연결하기
    public void removeNode(int data) {
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node curNode = head;
        Node preNode = null;
        Node nextNode = null;
        while (true) {
            if (curNode == null)
                return;

            if (curNode.data == data) {
                nextNode = curNode.next;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }

        preNode.next = nextNode;

    }

    public int getList(int[] output) {
        int idx = 1;
        Node cur = head;
        output[0] = cur.data;
        while (cur.next != null) {
            cur = cur.next;
            output[idx] = cur.data;
            idx++;
        }
        return idx;
    }
}