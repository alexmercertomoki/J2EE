package edu.cmu.cs.webapp.addrbook.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import edu.cmu.cs.webapp.addrbook.databean.Entry;
import edu.cmu.cs.webapp.addrbook.formbean.AdvancedSearchForm;

public class EntryDAO extends GenericDAO<Entry> {
	private MyComparator comparator = new MyComparator(false);
	private MyComparator spouseComparator = new MyComparator(true);

	public EntryDAO(ConnectionPool pool) throws DAOException {
		super(Entry.class, "entry", pool);
	}
	
	private void addIfNotEmpty(List<MatchArg> constraintList, String propName, String value) {
		if (value == null) return;
		if (value.length() == 0) return;
		constraintList.add(MatchArg.containsIgnoreCase(propName,value));
	}
	
	public Entry[] lookupAdvanced(AdvancedSearchForm form) throws RollbackException {
		List<MatchArg> constraintList = new ArrayList<MatchArg>();
		
		if (form.getLastName().length() > 0) {
			constraintList.add(
					MatchArg.or(
							MatchArg.containsIgnoreCase("lastName", form.getLastName()),
							MatchArg.containsIgnoreCase("spouseLast", form.getLastName())));
		}

		if (form.getFirstName().length() > 0) {
			constraintList.add(
					MatchArg.or(
							MatchArg.containsIgnoreCase("firstNames", form.getFirstName()),
							MatchArg.containsIgnoreCase("spouseFirst", form.getFirstName())));
		}


		if (form.getAnyPhone().length() > 0) {
			constraintList.add(
					MatchArg.or(
							MatchArg.containsIgnoreCase("cellPhone", form.getAnyPhone()),
							MatchArg.containsIgnoreCase("fax", form.getAnyPhone()),
							MatchArg.containsIgnoreCase("homePhone", form.getAnyPhone()),
							MatchArg.containsIgnoreCase("workPhone", form.getAnyPhone()),
							MatchArg.containsIgnoreCase("spouseCell", form.getAnyPhone()),
							MatchArg.containsIgnoreCase("spouseWork", form.getAnyPhone())));
		}

		if (form.getEmail().length() > 0) {
			constraintList.add(
					MatchArg.or(
							MatchArg.containsIgnoreCase("email", form.getEmail()),
							MatchArg.containsIgnoreCase("spouseEmail", form.getEmail())));
		}

		addIfNotEmpty(constraintList,"additional",form.getAdditional());
		addIfNotEmpty(constraintList,"address",form.getAddress());
		addIfNotEmpty(constraintList,"city",form.getCity());
		addIfNotEmpty(constraintList,"state",form.getState());
		addIfNotEmpty(constraintList,"country",form.getCountry());
		addIfNotEmpty(constraintList,"zip",form.getZip());

		addIfNotEmpty(constraintList,"receivedCards",form.getReceivedCards());
		addIfNotEmpty(constraintList,"sentCards",form.getSentCards());


		if (constraintList.size() == 0) return new Entry[0];
		
		MatchArg[] constraints = constraintList.toArray(new MatchArg[constraintList.size()]);
		Entry[] list = match(constraints);
		Arrays.sort(list,comparator);
		return list;
	}

	public Entry[] lookupStartsWith(String startOfLast, String startOfFirst) throws RollbackException {
		Entry[] list = match(
				MatchArg.startsWithIgnoreCase("lastName",startOfLast),
				MatchArg.startsWithIgnoreCase("firstNames",startOfFirst));
		Arrays.sort(list,comparator);
		return list;
	}

	public Entry[] lookupSpouseStartsWith(String startOfLast, String startOfFirst) throws RollbackException {
		Entry[] list = match(
				MatchArg.startsWithIgnoreCase("spouseLast",startOfLast),
				MatchArg.startsWithIgnoreCase("spouseFirst",startOfFirst));
		Arrays.sort(list,spouseComparator);
		return list;
	}
	
	public Entry update(String oldDigest, Entry newEntry) throws RollbackException {
		try {
			Transaction.begin();
			
			int id = newEntry.getId();
			
			Entry oldEntry = read(id);
			if (oldEntry == null) {
				throw new RollbackException("No entry in database: id="+newEntry.getId()+".  (Someone else must have just deleted it.)");
			}
			
			if (!oldDigest.equals(computeDigest(oldEntry))) {
				throw new RollbackException("Entry in database has been changed by someone else.  (Enter your changes again.)");
			}
			
			update(newEntry);
			Transaction.commit();
			
			// return oldEntry so that we can write into the log the old and new values
			return oldEntry;
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	private static class MyComparator implements Comparator<Entry> {
		private boolean spouseCompare;
		
		public MyComparator(boolean spouseCompare) {
			this.spouseCompare = spouseCompare;
		}
		
		// Sorts by lastname then firstname or spouse's last then spouse's first,
		// depending on setting of spouseCompare variable.
		public int compare(Entry e1, Entry e2) {
			int lastCompare;
			if (spouseCompare) {
				lastCompare = compareNames(e1.getSpouseLast(),e2.getSpouseLast());
			} else {
				lastCompare = compareNames(e1.getLastName(),e2.getLastName());
			}
			
			if (lastCompare != 0) return lastCompare;
			
			int firstCompare;
			if (spouseCompare) {
				firstCompare = compareNames(e1.getSpouseFirst(),e2.getSpouseFirst());
			} else {
				firstCompare = compareNames(e1.getFirstNames(),e2.getFirstNames());
			}
			
			if (firstCompare != 0) return firstCompare;
			
			return e2.getId()-e1.getId();
		}
		
		private int compareNames(String n1, String n2) {
			// The application never stores null names in the database, but
			// just in case someone puts a null name in there...
			if (n1 == null && n2 == null) return 0;
			if (n1 == null) return -1;
			if (n2 == null) return 1;
			return n1.compareTo(n2);
		}
	};
}
