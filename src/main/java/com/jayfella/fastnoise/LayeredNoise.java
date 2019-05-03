package com.jayfella.fastnoise;

import com.jme3.math.Vector2f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LayeredNoise {

    private final List<NoiseLayer> layers = new ArrayList<>();
    private final Map<NoiseLayer, NoiseLayer> layerMasks = new HashMap<>();

    public LayeredNoise() {
    }

    public void addLayer(NoiseLayer noiseLayer) {
        layers.add(noiseLayer);
    }

    public void removeLayer(NoiseLayer noiseLayer) {
        layers.remove(noiseLayer);
    }

    public List<NoiseLayer> getLayers() {
        return layers;
    }

    public void maskLayer(NoiseLayer layer, NoiseLayer with) {
        layerMasks.put(layer, with);
    }

    public void removeMask(NoiseLayer noiseLayer) {
        layerMasks.remove(noiseLayer);
    }

    public float evaluate(Vector2f v) {

        float result = 0;

        for (NoiseLayer layer : layers) {

            NoiseLayer mask = layerMasks.get(layer);

            float layerNoise = layer.evaluate(v);

            if (mask != null) {
                layerNoise *= mask.evaluate(v);
            }

            layerNoise *= layer.getStrength();
            result += layerNoise;
        }

        return result;
    }

}
