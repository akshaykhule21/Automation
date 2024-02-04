package testDataManager;

public class RunManager {
	/**
	 * This class is use use to decide which classes to run and which to skip
	 * when you run jenkins then mvn clean test command executes
	 * which runs the test classes mentioned in pom.xml file under maven-surerfire plugin
	 * if classes are mentioned there(pom.xml) then only they run
	 * and you can control it from here
	**/

	
	public static boolean isEnabledSANITY=false;		
	public static boolean isEnabledAllInsurer=true;		
	public static boolean isEnabledBrandNew=true;
	public static boolean isEnabledPWCN=true;
	public static boolean isEnabledQUOTE=true;
	public static boolean isEnabledRenewal=true;
	public static boolean isEnabledRenewal_All=true;
	public static boolean isEnabledTP=true;
	public static boolean isEnabledProposal=true;
}