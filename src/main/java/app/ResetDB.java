package app;

public class ResetDB {
	public static void main(String[] args) {
		DatabaseManager databaseManager = new DatabaseManager();
		databaseManager.delete();
	}
}
