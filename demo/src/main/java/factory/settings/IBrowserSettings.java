package factory.settings;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.AbstractDriverOptions;

public interface IBrowserSettings {

    AbstractDriverOptions settings ();
    
}
