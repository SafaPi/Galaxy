/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Map;

/**
 *
 * @author SafaPC
 */

public class showLocation {
        private String ApiKey = "";

  public void showLocation(String city, String country, int width, int height) throws Exception {
        this.setMap(city, country, width, height);
    }
  public void setApiKey(String key) {
        this.ApiKey = key;
  }
     private void setMap(String x, String y, Integer width, Integer height) throws Exception {
        if (this.ApiKey.isEmpty()) {
            throw new Exception("Developper API Key not set !!!!");
        }
        
    }
}
