(ns game.components.transform
  (:require [engine.component :as component]))

(defrecord Transform [x y]
  component/Component
  (get-key [_] :transform)
  (update [this entity dT]))
