JME-FastNoise
===

An extensive noise library for generating 2D noise in jmonkeyengine.

Generates the following noise types:
- Value
- ValueFractal
- Perlin
- PerlinFractal
- Simplex
- SimplexFractal
- Cellular
- WhiteNoise
- Cubic
- CubicFractal

Create layered noise using multiple noise layers.

``` java

LayeredNoise layeredNoise = new LayeredNoise();

NoiseLayer layer1 = new NoiseLayer();
noiseLayer.setSeed(213);
noiseLayer.setNoiseType(FastNoise.NoiseType.PerlinFractal);
noiseLayer.setStrength(32);
noiseLayer.setOctaves(8);

NoiseLayer layer2 = new NoiseLayer();

layeredNoise.addLayer(layer1);
layeredNoise.addLayer(layer2);

// if you're generating terrain you can set a hard floor.
// this "boosts" the floor level to create a distinction between land and sea.
layeredNoise.setHardFloor(true);
layeredNoise.setHardFloorHeight(10.0f);

layeredNoise.evaluate(new Vector2f(x, y));

```

Or just use a single layer.

``` java
NoiseLayer layer1 = new NoiseLayer();
layer1.evaluate(new Vector2f(x, y));

```
