(ns engine.sprite)

(let [canvas (.getElementById js/document "game-canvas")]
  (def ctx (.getContext canvas "2d"))
  (def WIDTH (.-width canvas))
  (def HEIGHT (.-height canvas))
  (def ctx-pos
    (loop [x 0
           y 0
           elem canvas]
      (if elem
        (recur
         (+ x (.-offsetLeft elem))
         (+ y (.-offsetTop elem))
         (.-offsetParent elem))
        {:x x :y y}))))

(defn update [self entity]
  (let [pos @(:pos entity)
        w (:w @self)
        h (:h @self)
        x (- (:x pos) (/ w 2))
        y (- (:y pos) (/ h 2))]
    (.clearRect ctx 0 0 WIDTH HEIGHT)
    (set! (.-fillStyle ctx) "red")
    (.fillRect ctx x y w h)
    ))
