(ns game.core
  (:require [game.util :as util]
            [engine.vec2 :as  vec2]
            [engine.component :as component]
            [game.components.sprite :as sprite]
            [game.components.transform :as transform]))

(defn set-text [id text]
  (set!
   (.-innerText (.getElementById js/document id))
   text))

(defn set-html [id html]
  (set!
   (.-innerHTML (.getElementById js/document id))
   html))

(defn init []
  #_(set-html
   "game-body"
   "<div class=\"box\" id=\"player\"></div>")
  )

(def mousePos (atom {:x 12 :y 15}))
mousePos
(:x (deref mousePos))

(def box {:sprite (atom (sprite/->Sprite 40 65 "#2c8"))
          :transform (atom (transform/->Transform 450 550))
          :spd 350})

(defn update-text [dT]
  (set-text "text"
            (str
             @mousePos
             " :: "
             box))
  )

(defn update-box [dT]
  (let [pos (:transform box)
        deltaPos (vec2/sub @mousePos @pos)
        movDist (min (* dT (:spd box))

                     (vec2/len deltaPos))
        dir (vec2/unit deltaPos)]
    (swap! pos (fn [p]
                 (let [v
                       (vec2/add
                        p
                        (vec2/scalar-mult movDist dir))]
                   (assoc p :x (:x v) :y (:y v)))))
    (component/update @(:sprite box) box dT)))

(let [lastFrame (atom (js/Date.now))]
  (defn game-update []
    (let [dT (util/time-since @lastFrame)]
      (update-text dT)
      (update-box dT))
    (swap! lastFrame js/Date.now)))

(init)
(.setInterval js/window game-update 33)
(set!
 (.-onmousemove js/window)
 (fn [e]
   (swap!
    mousePos
    (fn [p] (vec2/sub
             (assoc p
               :x (.-clientX e)
               :y (.-clientY e))
             sprite/ctx-pos)))))
