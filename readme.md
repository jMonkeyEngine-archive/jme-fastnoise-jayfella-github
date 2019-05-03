JME-FastNoise
===

An extensive noise library for generating 2D noise in jmonkeyengine.


Create layered noise using multiple noise layers.

``` 

LayeredNoise layeredNoise = new LayeredNoise();

NoiseLayer layer1 = new NoiseLayer();
NoiseLayer layer2 = new NoiseLayer();

layeredNoise.evaluate(new Vector2f(x, y));

```

Or just use a single layer.
```
NoiseLayer layer1 = new NoiseLayer();
layer1.evaluate(new Vector2f(x, y));

```
