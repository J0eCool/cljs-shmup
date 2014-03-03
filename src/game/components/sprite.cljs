(ns game.components.sprite
  (:require [engine.component :as component]))

(let
  [canvas (.getElementById js/document "game-canvas")
   ctx (.getContext canvas "2d")
   WIDTH (.-width canvas)
   HEIGHT (.-height canvas)
   ctx-pos (loop [x 0
                  y 0
                  elem canvas]
             (if elem
               (recur
                (+ x (.-offsetLeft elem))
                (+ y (.-offsetTop elem))
                (.-offsetParent elem))
               {:x x :y y}))]


  (defrecord Sprite [w h color]
    component/Component
    (get-key [_] :sprite)
    (update [this entity dT]
            (let [pos @(:transform entity)
                  x (- (:x pos) (/ w 2))
                  y (- (:y pos) (/ h 2))]
              (set! (.-fillStyle ctx) "#222")
              (.fillRect ctx 0 0 WIDTH HEIGHT)
              (set! (.-fillStyle ctx) color)
              (.fillRect ctx x y w h)))))
