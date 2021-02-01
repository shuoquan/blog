import axios from 'axios';
import { url } from '../../config';

export function timeDuration () {
  return axios({
    url: `${url}/user/clerk/boxes`,
    method: 'get',
  });
}
