# JEyeborg
`JEyeborg` is a sonochromatism [[1]](#link) (color to sound perception) simulator written in Java.
It is inspired by the Eyeborg [[2]](#links) concept in Neil Harbisson's "I see color" TED Talk [[3]](#links).

## Usage
Run the included `JEyeborg.jar` or compile from source.

Choose an image using the file browser dialog.

Dragging the mouse along an image loaded into `JEyeborg` will play the notes associated with image pixels traversed by the cursor.

## Sonochromatic Map

The current mapping from color to sound is loosely based on Neil Harbisson's sonochromatic scales [[1]](#links)[[2]](#links).

Hue values on the color wheel are mapped to frequencies in the range near F#4 through F#5.

Microtone[[4]](#links) sound synthesis is achieved using JFugue [[5]](#links).

## Links<a name="links"></a>
1. [Sonochromatism](http://en.wikipedia.org/wiki/Sonochromatism) Wikipedia article <a name="link1">
2. [Eyeborg](http://en.wikipedia.org/wiki/Eyeborg) Wikipedia article
3. [Neil Harbisson's "I listen to color" TED Talk](https://www.youtube.com/watch?v=ygRNoieAnzI)
5. [Microtonal Music](http://en.wikipedia.org/wiki/Microtonal_music) Wikipedia Article
4. [JFugue](http://www.jfugue.org/)