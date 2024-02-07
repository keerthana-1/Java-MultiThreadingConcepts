package edu.umb.cs681.hw15;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable<T> {

	private ReentrantLock lock=new ReentrantLock();
	private LinkedList<Observer<T>> observers = new LinkedList<>();
	
	public void addObserver(Observer<T> o) {
		lock.lock();
		try {
			observers.add(o);
		}
		finally{
			lock.unlock();
		}
	}


	public void clearObservers() {
		lock.lock();
		try {
			observers.clear();
		}
		finally {
			lock.unlock();
		}
		
	}
	public List<Observer<T>> getObservers(){
		lock.lock();
		try {
			return observers;
		}
		finally {
			lock.unlock();
		}
	}
	
	public int countObservers() {
		lock.lock();
		try {
			return observers.size();
		}
		finally {
			lock.unlock();
		}
		
	}
	public void removeObserver(Observer<T> o) {
		lock.lock();
		try {
			observers.remove(o);
		}
		finally {
			lock.unlock();
		}
	}

	public void notifyObservers(T event) {

		LinkedList<Observer<T>> local_observers = new LinkedList<>();

		lock.lock();
		try {
			local_observers=observers;
		}
		finally {
			lock.unlock();
		}

		local_observers.forEach((observer) -> {
			observer.update(this, event);
		});
	}
	
}
