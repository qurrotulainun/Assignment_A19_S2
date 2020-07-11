public interface Stack {
	public Object getTop();
	public void push (Object obj);
	public Object pop();
}

public class StackAsArray extends AbstactContainer
		implements Stack {
			protected Object[] array;
			public StackAsArray (int size) {
				array = new Object[size];
			}

public void purge () {
	while (count > 0)
		array[--count] = null;
}		

public void push (Object object) {
	if (count == array.length)
		throw new ContainerFullException();
	else
		array[count++] = object;
}

public Object pop() {
	if (count == 0)
		throw new ContainerEmptyException();
	else{
		Object result = array[--count];
		array[count] = null;
		return result;
	}
}

public Object getTop() {
	if (count == 0)
		throw new ContainerEmptyException();
	else
		return array[count - 1];
}

public Iterator iterator() {
	return new Iterator() {
		private int position = count-1;
		public boolean hasNext() {
			return position >= 0;
		}
		public Object next() {
			if(position < 0)
				throw new NoSuchElemenException();
			else
				return array [position--];
		}
	};
}

public class StackAsLinkedList
	extends AbstactContainer
	implements Stack {
		protected MyLinkedList list;
		public StackAsLinkedList() {
			list = new MyLinkedList ();
		}
		public void purge () {
			list.purge();
			count = 0;
		}
	
public void push (Object obj) {
	list.prepend (obj);
	count++;
}
public Object pop() {
	if(count == 0)
		throw new ContainerEmptyException();
	else{
		Object obj = list.getFirst();
		list.extractFirst ();
		count--;
		return obj;
	}
}
public Object getTop() {
	if(count == 0)
		throw new ContainerEmptyException();
	else 
		return list.getFirst();
}

public Iterator iterator() {
	return new Iterator() {
		private MyLinkedList.Element position =
			list.getHead();
		public boolean hasNext() {
			return position	!= null;
		}
		public Object next() {
			if (position == null)
				throw new NoSuchElemenException();
			else {
				Object obj = position.getData();
				position = position.getNext():
				return obj;
			}
		}
	};
}