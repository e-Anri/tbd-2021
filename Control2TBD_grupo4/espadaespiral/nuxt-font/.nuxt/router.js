import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _6cd40648 = () => interopDefault(import('..\\pages\\acerca-de.vue' /* webpackChunkName: "pages/acerca-de" */))
const _91099d4e = () => interopDefault(import('..\\pages\\actualizar.vue' /* webpackChunkName: "pages/actualizar" */))
const _ff17dfec = () => interopDefault(import('..\\pages\\eliminar.vue' /* webpackChunkName: "pages/eliminar" */))
const _6c6122ea = () => interopDefault(import('..\\pages\\lista.vue' /* webpackChunkName: "pages/lista" */))
const _cbffe6b0 = () => interopDefault(import('..\\pages\\nosotros.vue' /* webpackChunkName: "pages/nosotros" */))
const _d9e04fc4 = () => interopDefault(import('..\\pages\\nuevo.vue' /* webpackChunkName: "pages/nuevo" */))
const _554de36f = () => interopDefault(import('..\\pages\\delete\\id.vue' /* webpackChunkName: "pages/delete/id" */))
const _0389988d = () => interopDefault(import('..\\pages\\update\\id.vue' /* webpackChunkName: "pages/update/id" */))
const _f5b0ae8e = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/acerca-de",
    component: _6cd40648,
    name: "acerca-de"
  }, {
    path: "/actualizar",
    component: _91099d4e,
    name: "actualizar"
  }, {
    path: "/eliminar",
    component: _ff17dfec,
    name: "eliminar"
  }, {
    path: "/lista",
    component: _6c6122ea,
    name: "lista"
  }, {
    path: "/nosotros",
    component: _cbffe6b0,
    name: "nosotros"
  }, {
    path: "/nuevo",
    component: _d9e04fc4,
    name: "nuevo"
  }, {
    path: "/delete/id",
    component: _554de36f,
    name: "delete-id"
  }, {
    path: "/update/id",
    component: _0389988d,
    name: "update-id"
  }, {
    path: "/",
    component: _f5b0ae8e,
    name: "index"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
