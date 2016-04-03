package Map;
 
import static java.awt.Color.red;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
 
public class GoogleMapSample extends JEditorPane
{
     
    private float longitude;
    private float latitude;
 
    private static final long serialVersionUID = 1L;
    private int zoomFactor = 15;
    private String ApiKey = "ABQIAAAA5U876NY9uQtuJYcYdj0hPRSB3fYKqo9sRR7o2MKyAKh3L0V4NBREpf50rgLOScH_jEQR7BtpLbAZ0g";
    private String roadmap = "roadmap";
    public final String viewTerrain = "terrain";
    public final String viewSatellite = "satellite";
    public final String viewHybrid = "hybrid";
    public final String viewRoadmap = "roadmap";
    private String bouton = "";
    private String cursor ="";
    private String line ="";
    public GoogleMapSample(float longitude,float latitude)
    {
        HTMLEditorKit kit = new HTMLEditorKit();
        HTMLDocument htmlDoc = (HTMLDocument) kit.createDefaultDocument();
        this.setEditable(false);
        this.setContentType("text/html");
        this.setEditorKit(kit);
        this.setDocument(htmlDoc);
        this.setLongitude(longitude);
        this.setLatitude(latitude);
 
    }
 
    public void setZoom(int zoom) {
        this.zoomFactor = zoom;
    }
    public int getZoom() {
        return zoomFactor;
    }
    public void setApiKey(String key) {
        this.ApiKey = key;
    }
    public void setRoadmap(String roadMap) {
        this.roadmap = roadMap;
    }

    public void showCoordinate(int width, int height) throws Exception {
        this.setMap(Float.toString(latitude),Float.toString(longitude) , width, height);
    }
 
    public void showLocation(String city, String country, int width, int height) throws Exception {
        this.setMap(city, country, width, height);
    }
 
    private void setMap(String x, String y, Integer width, Integer height) throws Exception {
        if (this.ApiKey.isEmpty()) {
            throw new Exception("Developper API Key not set !!!!");
        }
 
        String url = " http://maps.google.com/maps/api/staticmap?";
        url += "center=" + x + "," + y;
        url += "&amp;zoom=" + this.zoomFactor;
        url += "&markers=color:red%7C" + x + "," +y;
        url += "&amp;size=" + width.toString() + "x" + height.toString();
        url += "&amp;maptype=" + this.roadmap;
        url += cursor;
        url += line;
        url += "&amp;sensor=false";
        String html = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>";
        html += "<html><head></head>";
        html +=    "<body><img src='" + url + "'>";
        html += "</body></html>";
        this.setText(html);
    
    }
   
    public void setLongitude(float longitude) {this.longitude = longitude;}
    public float getLongitude() {return longitude;}
    public void setLatitude(float latitude) {this.latitude = latitude;}
    public float getLatitude() {return latitude;}

public static void main(String[] args)  {

JFrame frame = new JFrame();

        try {
            GoogleMapSample m = new GoogleMapSample(7.753544f,87.226174f);
            m.showLocation("Tunsie", "Marsa", 390, 400);
            frame.add(m);

        } catch (Exception ex) {
            Logger.getLogger(GoogleMapSample.class.getName()).log(Level.SEVERE, null, ex);
        }            

frame.setSize(400, 420);
frame.setLocation(200, 200);
frame.setVisible(true);
     

}

    
}