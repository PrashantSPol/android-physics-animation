# android-physics-animation
Project to demonstrate cool physics animations in Android. 
Unlike normal animations in android, physics animation provides seemless and smooth animations for objects and view components, which avoids visual disturbances for users. Momentum and velocity of an object is considered to move an object from a dynamic state to the state of equilibrium and a vice versa.

## Move object back to original position
Spring Animation demo to move object to a given position,
this demonstrate translation of views.
When we drag object from its original position and leave it, which makes object to move back to its original position but because of having a momentum while reaching its original position, it oscillates for a while before reaching state of equilibrium.

![](https://github.com/PrashantSPol/android-physics-animation/blob/master/gif/back_to_my_position.gif)

## Enlarge view as we drag down
Spring Animation demo to enlarge views seemlessly when we drag it down,
this demonstrate scaling of views.
When we drag an object towards bottom of the screen, it will be enlarged and when we move it back upwards, it will start shrinking with smooth animation.

![](https://github.com/PrashantSPol/android-physics-animation/blob/master/gif/enlarge_as_go_down.gif)

## Follow me chain animation
Spring Animation demo to create chain animation.
Two followers are made to follow drag movement of their leader.
When we drag right most object it will make its previous object to follow it and it will further make third one to follow.
Which leads to nice and smooth chain like animation.

![](https://github.com/PrashantSPol/android-physics-animation/blob/master/gif/follow_me.gif)

## Select image demo
Animation to scale up and scale down view size to achieve effect as if it was selected.
In a grid of images when we select few images, changing them to shrink makes good feedback for user as it was selected.
This is a demo with such custom imageview created to shrink and toggle back to its original position on an action of selection.

![](https://github.com/PrashantSPol/android-physics-animation/blob/master/gif/select_image_animation.gif)
