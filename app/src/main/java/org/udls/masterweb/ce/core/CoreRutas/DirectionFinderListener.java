package org.udls.masterweb.ce.core.CoreRutas;
import org.udls.masterweb.ce.model.Route;

import java.util.List;

/**
 * Created by Mai Thanh Hiep on 4/3/2016.
 */
public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
