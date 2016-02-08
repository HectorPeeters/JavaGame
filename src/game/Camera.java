package game;

import math.Vector2i;

public class Camera {

    public static Vector2i position = new Vector2i(0, 0);
    public static float zoom = 0;
    public static final float MAX_ZOOM = 20f;
    public static final float MIN_ZOOM = 0;

    public static void setZoom(float value) {
        if (value > MAX_ZOOM) zoom = MAX_ZOOM;
        else if (value < MIN_ZOOM) zoom = MIN_ZOOM;
        else zoom = value;
    }

    public static void zoomIn() {
        setZoom(zoom + 1);
    }

    public static void zoomOut() {
        setZoom(zoom - 1);
    }
}
