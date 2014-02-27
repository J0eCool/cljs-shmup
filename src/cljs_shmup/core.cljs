(ns cljs-shmup.core
  (:require [cljs-shmup.util :as util]
            [cljs-shmup.vec2 :as  vec2]))

(defn set-text [id text]
  (set!
   (.-innerText (.getElementById js/document id))
   text))

(defn set-html [id html]
  (set!
   (.-innerHTML (.getElementById js/document id))
   html))

(defn init []
  (set-html
   "game-body"
   "<div class=\"box\" id=\"player\"></div>"))

(defn update-text [dT]
  (set-text "text"
            (str
             @mousePos
             " :: "
             box))
  )

(def mousePos (atom {:x 12 :y 15}))
mousePos

(def box {:id "player"
          :pos (atom {:x 450 :y 550})
          :spd 350})
(defn update-box [dT]
  (let [elem (.getElementById js/document (:id box))
        style (.-style elem)
        pos (:pos box)
        deltaPos (vec2/sub @mousePos @pos)
        movDist (min (* dT (:spd box))
                     (vec2/len deltaPos))
        dir (vec2/unit deltaPos)]
                     ;(vec2/len deltaPos))

    (swap! pos (fn [p]
                 (let [])
                 (vec2/add
                  p
                  (vec2/scalar-mult movDist dir))))
    (set! (.-left style) (str (:x @pos) "px"))
    (set! (.-top style) (str (:y @pos) "px"))))

(let [lastFrame (atom (js/Date.now))]
  (defn update []
    (let [dT (util/time-since @lastFrame)]
      (update-text dT)
      (update-box dT))
    (swap! lastFrame js/Date.now)))

(init)
(.setInterval js/window update 33)
(set!
 (.-onmousemove js/window)
 (fn [e]
   (swap!
    mousePos
    (fn [] (assoc @mousePos
             :x (.-clientX e)
             :y (.-clientY e))))))
