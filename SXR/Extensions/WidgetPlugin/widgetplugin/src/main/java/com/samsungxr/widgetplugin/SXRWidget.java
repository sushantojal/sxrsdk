/* Copyright 2015 Samsung Electronics Co., LTD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.samsungxr.widgetplugin;

import com.badlogic.gdx.ApplicationAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * SXRWidget is a wrapper for LibGDX widget. base class for application widget
 * implementation
 */

public abstract class SXRWidget extends ApplicationAdapter {

    private int mTexid;
    private CountDownLatch mInitializedLatch = new CountDownLatch(1);

    @Override
    public void notifyCreation(int id) {
        mTexid = id;
        mInitializedLatch.countDown();
    }

    public int getTexId() {
        try {
            mInitializedLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mTexid;
    }

}