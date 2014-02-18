package net.anselstetter.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class TripleMap<A, B, C> {
	private Map<A, Map<B, C>> map = new HashMap<A, Map<B, C>>();

	public C put(A a, B b, C c) {
		if (!map.containsKey(a)) {
			map.put(a, new HashMap<B, C>());
		}
		map.get(a).put(b, c);
		return c;
	}

	public C remove(A a, B b) {
		if (!map.containsKey(a)) {
			return null;
		}
		return map.get(a).remove(b);
	}

	public boolean isEmpty(A a) {
		if (!map.containsKey(a)) {
			return true;
		}
		return map.get(a).isEmpty();
	}

	public C get(A a, B b) {
		if (!map.containsKey(a)) {
			return null;
		}

		return map.get(a).get(b);
	}

	public boolean containsKey(A a) {
		return map.containsKey(a);
	}

	public boolean containsKey(A a, B b) {
		if (!map.containsKey(a)) {
			return false;
		}

		return map.get(a).containsKey(b);
	}

	public boolean containsValue(A a, B c) {
		if (!map.containsKey(a)) {
			return false;
		}

		return map.get(a).containsValue(c);
	}

	public Collection<Map<B, C>> values() {
		return map.values();
	}

	public Collection<C> values(A a) {
		if (!map.containsKey(a)) {
			return null;
		}

		return map.get(a).values();
	}

	public Set<A> keySet() {
		return map.keySet();
	}

	public Set<B> keySet(A a) {
		if (!map.containsKey(a)) {
			return null;
		}

		return map.get(a).keySet();
	}
}