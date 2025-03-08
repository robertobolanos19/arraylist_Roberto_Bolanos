package junits;

import org.junit.Test;
import static org.junit.Assert.*;

import utils.ArrayList;

public class JUNIT01QQArrayListTest {

    @Test
    public void testAdd() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        assertEquals(2, list.size());
        assertEquals((Integer) 10, list.get(0));
        assertEquals((Integer) 20, list.get(1));
    }

    @Test
    public void testAddAtIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(1, 15);
        assertEquals(3, list.size());
        assertEquals((Integer) 15, list.get(1));
    }

    @Test
    public void testRemove() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(1);
        assertEquals(2, list.size());
        assertEquals((Integer) 30, list.get(1));
    }

    @Test
    public void testContains() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        assertTrue(list.contains(10));
        assertFalse(list.contains(50));
    }

    @Test
    public void testClear() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
}