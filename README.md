# Preview

| ![](https://github.com/anurbanv/android-circle-progress-compose/blob/main/content/app-preview.gif) | ![app screen](https://github.com/anurbanv/android-circle-progress-compose/blob/main/content/app-preview-screen.png) |
|-|-|

# Segmented Gradient Arc

## Overview
The Segmented Gradient Arc converts a given angle into a line arc drawn on a canvas with a specified radius and thickness. The arc is divided into 90-degree segments, offering more control over the gradient colors.

## Features
- **Arc Segmentation:** 
  - The arc is divided into 90-degree segments, giving more control over the gradient colors.
  - The arc is drawn using multiple small lines, and the smoothness can be adjusted using a step value.
  - The arc is drawn segment by segment, with the final segment calculating the last angle value.

- **Gradient Color Control:**
  - The color list for the gradient changes depending on the given angle.
  - The total list of colors by segment is: 
    - [Bright Blue, Lilac, Red, Red, Red, Red, Rose Pink, Rose Pink, Rose Pink]
  - There are a total of 8 segments (2 circles * 4 segments) and 9 colors in total.

- **Input Slider Animation:**
  - The input slider adjusts the percentage value and animates from the current position to the given position over a duration of 2 seconds.
