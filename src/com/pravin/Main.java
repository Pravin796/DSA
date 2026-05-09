import com.pravin.CLL;
import com.pravin.Dll;
import com.pravin.Linkedlist;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
//    Linkedlist LL = new Linkedlist();
//    LL.insertfirst(10);
//    LL.insertfirst(20);
//    LL.insertfirst(30);
//    LL.insertfirst(50);
//
//    LL.display();
//    LL.insertLast(11);
//    LL.display();
//    LL.removeFirst();
//    LL.display();
//
//    LL.getll( 3);
////    LL.removeLast();
//    IO.println("after the get val");
//    LL.display();
//
//    LL.set(1,110);
//    IO.println("after the linked updated");
//    LL.display();
//    LL.insert(1,15);
//    LL.display();
//    LL.remove(1);
//    LL.find(110);
//    LL.display();

//    Dll dll = new Dll();
//    dll.insertFirst(10);
//    dll.insertFirst(20);
//    dll.insertFirst(30);
//    dll.insertFirst(40);
//    dll.insertFirst(50);
//    dll.insertLast(60);
//    dll.get(1);
//    dll.insertAt(1, 45);
//    dll.display();

    CLL cll = new CLL();
    cll.insertFirst(10);
    cll.insertFirst(20);
    cll.insertFirst(30);
    cll.insertFirst(40);
    cll.insertLast(50);

    cll.delete(40);
    cll.display();
}
