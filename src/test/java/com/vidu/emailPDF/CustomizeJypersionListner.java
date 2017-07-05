/**
 * 
 */
package emailPDF;

import java.awt.Color;
import java.util.Random;

import org.testng.ITestResult;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import bookfariscripts.BookfariInOneGo;
import bookfariscripts.TakeScreenshot;

/**
 * @author Vidushi Mishra
 *
 */
public class CustomizeJypersionListner {

	private PdfPTable failTable;
	private int nbException;
	private Object ThrowableMap;

	public void onTestFailure(ITestResult result){
		
		log("onTestFailure("+result+")");
		
		String file = System.getProperty("user.dir")+"\\"+"screenshot"+(new Random().nextInt())+".png";
		try {
			TakeScreenshot.getscreenshot(BookfariInOneGo.openBrowser());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		
		}
		if (this.failTable ==null)
		{
			this.failTable = new PdfPTable( new float[]{.3f, .3f, .1f, .3f});
			this.failTable.setTotalWidth(20f);
			Paragraph p = new Paragraph("Failed Test", new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(Color.black);
			Throwable throwable = result.getThrowable();
			if (throwable != null) {
				((Object) this.ThrowableMap).put( new Integer(throwable.hashCode()), throwable);
				this.nbException++;
			}
		}
		
		
	}

	private void log(String string) {
		// TODO Auto-generated method stub
		
	}

}
