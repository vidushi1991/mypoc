/**
 * 
 */
package bookfariscripts;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.vidu.model.ISBN;
import com.vidu.utility.ISBNUtility;

/**
 * @author Vidushi Mishra
 *
 */
public class BowkerUpdate {
	@Test
	public void checkMonthlyBowkerUpdate() throws InterruptedException, IOException {
		BowkerISBNCheck objBowker = new BowkerISBNCheck();
		List<ISBN> listBowker =objBowker.bowkerUpdate();
		ISBNUtility objISBN = new ISBNUtility();
		objISBN.writeExcel(listBowker);
	}

}
