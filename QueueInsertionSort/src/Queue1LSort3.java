import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Layered implementations of secondary method {@code sort} for
 * {@code Queue<String>}.
 *
 * @param <T>
 *            type of {@code Queue} entries
 * @mathdefinitions <pre>
 * IS_TOTAL_PREORDER (
 *   r: binary relation on T
 *  ) : boolean is
 *  for all x, y, z: T
 *   ((r(x, y) or r(y, x))  and
 *    (if (r(x, y) and r(y, z)) then r(x, z)))
 *
 * IS_SORTED (
 *   s: string of T,
 *   r: binary relation on T
 *  ) : boolean is
 *  for all x, y: T where (<x, y> is substring of s) (r(x, y))
 * </pre>
 */
public final class Queue1LSort3<T> extends Queue1L<T> {

    /**
     * No-argument constructor.
     */
    public Queue1LSort3() {
        super();
    }

    /**
     * Inserts the given {@code T} in the {@code Queue<T>} sorted according to
     * the given {@code Comparator<T>} and maintains the {@code Queue<T>}
     * sorted.
     *
     * @param <T>
     *            type of {@code Queue} entries
     * @param q
     *            the {@code Queue} to insert into
     * @param x
     *            the {@code T} to insert
     * @param order
     *            the {@code Comparator} defining the order for {@code T}
     * @updates q
     * @requires <pre>
     * IS_TOTAL_PREORDER([relation computed by order.compare method])  and
     * IS_SORTED(q, [relation computed by order.compare method])
     * </pre>
     * @ensures <pre>
     * perms(q, #q * <x>)  and
     * IS_SORTED(q, [relation computed by order.compare method])
     * </pre>
     */
    private static <T> void insertInOrder(Queue<T> q, T x,
            Comparator<T> order) {
        assert q != null : "Violation of: q is not null";
        assert order != null : "Violation of: order is not null";

        // TODO - fill in body
        boolean done = false;
        if (q.length() > 0) {
            T min = q.front();
            if (order.compare(x, q.front()) <= 0) {
                q.enqueue(x);
                min = x;
                done = true;
            } else {
                for (int i = 0; !done && i < q.length(); i++) {
                    if (order.compare(x, q.front()) <= 0) {
                        q.enqueue(x);
                        done = true;
                    } else {
                        q.enqueue(q.dequeue());
                    }
                }
            }
            while (!q.front().equals(min)) {
                q.enqueue(q.dequeue());
            }
        }
        // In this case, the value of x is the largest in the Queue.
        if (!done) {
            q.enqueue(x);
        }
    }

    @Override
    public void sort(Comparator<T> order) {
        assert order != null : "Violation of: order is not null";

        // TODO - fill in body
        Queue<T> tmp = this.newInstance();
        while (this.length() != 0) {
            tmp.enqueue(this.dequeue());
        }
        int length = tmp.length();
        while (this.length() != length) {
            insertInOrder(this, tmp.dequeue(), order);
        }
    }

}
