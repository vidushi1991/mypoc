/**
 * 
 */
package testNGReport.realTimeReport;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bookfariscripts.BookfariReports;

/**
 * @author Vidushi Mishra
 *
 */

@Listeners(RealBookfariReport.class)

public class TestBookfariReport {
	@Test

    public void testRealReportOne(){

        Assert.assertTrue(true);

    }

    

    @Test

    public void testRealReportTwo(){

        Assert.assertTrue(false);

    }

    //Test case depends on failed testcase= testRealReportTwo

    @Test(dependsOnMethods="testRealReportTwo")

    public void testRealReportThree(){

        

}
}

