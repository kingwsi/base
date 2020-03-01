import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/api/auth',
    method: 'post',
    data
  })
}

export function getInfo() {
  return request({
    url: '/api/auth/info',
    method: 'get'
  })
}

export function logout() {
  return request({
    url: '/api/auth/logout',
    method: 'post'
  })
}
